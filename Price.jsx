import React, { useState } from "react";

function PriceManagement() {
  const [priceList] = useState([
    {
      priceId: 1,
      code: "BG001",
      name: "Bảng giá thường",
      effectDate: "2025-01-01",
      status: "Đang sử dụng",
      description: "Áp dụng cho khách hàng thường",
      details: [
        {
          minDur: 5,
          maxDur: 10,
          unit: 1000,
          type: "Đơn giá",
          amount: 500000,
        },
        {
          minDur: 11,
          maxDur: 20,
          unit: 1000,
          type: "Tam suất",
          amount: 800000,
        },
      ],
    },
    {
      priceId: 2,
      code: "BG002",
      name: "Bảng giá VIP",
      effectDate: "2025-02-01",
      status: "Đang sử dụng",
      description: "Áp dụng cho khách hàng VIP",
      details: [
        {
          minDur: 5,
          maxDur: 15,
          unit: 1000,
          type: "Đơn giá",
          amount: 1200000,
        },
      ],
    },
    {
      priceId: 3,
      code: "BG003",
      name: "Bảng giá đại lý",
      effectDate: "2025-03-01",
      status: "Ngưng sử dụng",
      description: "Áp dụng cho đại lý",
      details: [
        {
          minDur: 5,
          maxDur: 30,
          unit: 1000,
          type: "Đơn giá",
          amount: 350000,
        },
      ],
    },
  ]);

  const [searchTerm, setSearchTerm] = useState("");
  const [isModalOpen, setIsModalOpen] = useState(false);

  const [formData, setFormData] = useState({
    priceId: null,
    code: "",
    name: "",
    effectDate: "",
    status: "Đang sử dụng",
    description: "",
    details: [],
  });

  const filteredList = priceList.filter(
    (item) =>
      item.code.toLowerCase().includes(searchTerm.toLowerCase()) ||
      item.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleAdd = () => {
    setFormData({
      priceId: null,
      code: "",
      name: "",
      effectDate: "",
      status: "Đang sử dụng",
      description: "",
      details: [],
    });

    setIsModalOpen(true);
  };

  const handleEdit = (item) => {
    setFormData(item);
    setIsModalOpen(true);
  };

  const handleSave = () => {
    alert("Demo lưu dữ liệu thành công");
    setIsModalOpen(false);
  };

  const handleDelete = (id) => {
    if (window.confirm("Bạn có chắc chắn muốn xóa?")) {
      alert(`Demo xóa ID = ${id}`);
    }
  };

  return (
    <div className="p-6 bg-slate-50 min-h-screen">
      <div className="flex justify-between items-center mb-6">
        <div>
          <h2 className="text-2xl font-bold text-slate-800">
            Quản lý Bảng Giá
          </h2>

          <p className="text-slate-500 text-sm mt-1">
            Danh sách các bảng giá trong hệ thống
          </p>
        </div>

        <button
          onClick={handleAdd}
          className="bg-indigo-600 hover:bg-indigo-700 text-white px-4 py-2 rounded-lg shadow font-medium"
        >
          + Thêm Bảng Giá
        </button>
      </div>

      <div className="bg-white rounded-lg shadow border p-4 mb-5">
        <input
          type="text"
          placeholder="Tìm kiếm theo mã hoặc tên bảng giá..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="w-full border rounded-lg p-3 text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
      </div>

      <div className="bg-white rounded-lg shadow border overflow-x-auto">
        <table className="w-full text-sm">
          <thead className="bg-slate-100 border-b">
            <tr>
              <th className="p-4 text-left">Mã bảng giá</th>
              <th className="p-4 text-left">Tên bảng giá</th>
              <th className="p-4 text-left">Ngày áp dụng</th>
              <th className="p-4 text-left">Trạng thái</th>
              <th className="p-4 text-left">Mô tả</th>
              <th className="p-4 text-center">Hành động</th>
            </tr>
          </thead>

          <tbody>
            {filteredList.map((item) => (
              <tr
                key={item.priceId}
                className="border-b hover:bg-slate-50"
              >
                <td className="p-4 font-semibold text-indigo-600">
                  {item.code}
                </td>

                <td className="p-4">{item.name}</td>

                <td className="p-4">
                  {item.effectDate}
                </td>
                                <td className="p-4">
                  {item.status === "Đang sử dụng" ? (
                    <span className="px-3 py-1 rounded-full text-xs font-semibold bg-green-100 text-green-700">
                      Đang sử dụng
                    </span>
                  ) : (
                    <span className="px-3 py-1 rounded-full text-xs font-semibold bg-red-100 text-red-700">
                      Ngưng sử dụng
                    </span>
                  )}
                </td>

                <td className="p-4 text-slate-500">
                  {item.description}
                </td>

                <td className="p-4 text-center whitespace-nowrap">
                  <button
                    onClick={() => handleEdit(item)}
                    className="bg-blue-500 hover:bg-blue-600 text-white text-xs px-3 py-1.5 rounded mr-2"
                  >
                    Sửa
                  </button>

                  <button
                    onClick={() => handleDelete(item.priceId)}
                    className="bg-red-500 hover:bg-red-600 text-white text-xs px-3 py-1.5 rounded"
                  >
                    Xóa
                  </button>
                </td>
              </tr>
            ))}

            {filteredList.length === 0 && (
              <tr>
                <td
                  colSpan="6"
                  className="text-center p-8 text-slate-400 italic"
                >
                  Không tìm thấy dữ liệu
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      {isModalOpen && (
        <div className="fixed inset-0 bg-slate-900/40 backdrop-blur-sm flex items-center justify-center z-50">
          <div className="bg-white rounded-lg shadow-xl w-[900px] overflow-hidden">

            <div className="bg-[#004f9f] text-white p-4">
              <h3 className="font-bold text-lg">
                Chi tiết Bảng Giá
              </h3>
            </div>

            <div className="p-6 grid grid-cols-2 gap-5">

              <div className="space-y-4">

                <div>
                  <label className="block text-sm font-semibold mb-1">
                    Mã bảng giá
                  </label>

                  <input
                    type="text"
                    name="code"
                    value={formData.code}
                    onChange={handleChange}
                    className="w-full border rounded p-2 text-sm"
                  />
                </div>

                <div>
                  <label className="block text-sm font-semibold mb-1">
                    Tên bảng giá
                  </label>

                  <input
                    type="text"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    className="w-full border rounded p-2 text-sm"
                  />
                </div>

                <div>
                  <label className="block text-sm font-semibold mb-1">
                    Ngày áp dụng
                  </label>

                  <input
                    type="date"
                    name="effectDate"
                    value={formData.effectDate}
                    onChange={handleChange}
                    className="w-full border rounded p-2 text-sm"
                  />
                </div>

                <div>
                  <label className="block text-sm font-semibold mb-1">
                    Trạng thái
                  </label>

                  <select
                    name="status"
                    value={formData.status}
                    onChange={handleChange}
                    className="w-full border rounded p-2 text-sm"
                  >
                    <option value="Đang sử dụng">
                      Đang sử dụng
                    </option>

                    <option value="Ngưng sử dụng">
                      Ngưng sử dụng
                    </option>
                  </select>
                </div>

              </div>

              <div>
                <label className="block text-sm font-semibold mb-1">
                  Mô tả
                </label>

                <textarea
                  rows="11"
                  name="description"
                  value={formData.description}
                  onChange={handleChange}
                  className="w-full border rounded p-2 text-sm"
                />
              </div>

            </div>

            <div className="px-6 pb-6">

              <div className="flex justify-between items-center mb-3">
                <h4 className="font-bold text-slate-700">
                  Chi tiết bảng giá
                </h4>

                <button
                  className="bg-green-600 hover:bg-green-700 text-white text-xs px-3 py-2 rounded"
                >
                  + Thêm hạng mục giá
                </button>
              </div>

              <div className="border rounded-lg overflow-hidden">
                <table className="w-full text-sm">
                  <thead className="bg-slate-100">
                    <tr>
                      <th className="p-3 text-left">
                        Từ giây
                      </th>

                      <th className="p-3 text-left">
                        Đến giây
                      </th>

                      <th className="p-3 text-left">
                        Đơn vị
                      </th>

                      <th className="p-3 text-left">
                        Loại giá
                      </th>

                      <th className="p-3 text-left">
                        Giá tiền
                      </th>
                    </tr>
                  </thead>

                  <tbody>
                                        {formData.details?.length > 0 ? (
                      formData.details.map((detail, index) => (
                        <tr
                          key={index}
                          className="border-t hover:bg-slate-50"
                        >
                          <td className="p-3">
                            {detail.minDur}
                          </td>

                          <td className="p-3">
                            {detail.maxDur}
                          </td>

                          <td className="p-3">
                            {detail.unit}
                          </td>

                          <td className="p-3">
                            {detail.type}
                          </td>

                          <td className="p-3 font-semibold text-blue-600">
                            {detail.amount.toLocaleString()}
                          </td>
                        </tr>
                      ))
                    ) : (
                      <tr>
                        <td
                          colSpan="5"
                          className="p-4 text-center text-slate-400 italic"
                        >
                          Chưa có hạng mục giá
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>

            </div>

            <div className="bg-slate-50 p-4 flex justify-end gap-3 border-t">

              <button
                onClick={() => setIsModalOpen(false)}
                className="px-4 py-2 bg-slate-200 rounded font-medium"
              >
                Đóng
              </button>

              <button
                onClick={handleSave}
                className="px-4 py-2 bg-blue-600 text-white rounded font-medium"
              >
                Lưu dữ liệu
              </button>

            </div>

          </div>
        </div>
      )}

    </div>
  );
}

export default PriceManagement;
                
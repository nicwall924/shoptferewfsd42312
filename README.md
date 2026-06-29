# Java Deserialization Vulnerability Lab (PoC)

Repository này chứa mã nguồn Proof of Concept (PoC) mô phỏng lỗ hổng **Java Deserialization (Giải tuần tự hóa)** giữa ứng dụng Client và Server.

## 📌 Tổng quan về lỗ hổng
Lỗ hổng xảy ra khi phía Server nhận dữ liệu tuần tự hóa (serialized data) từ Client và thực hiện giải tuần tự (deserialize) bằng phương thức `ObjectInputStream.readObject()` mà không kiểm tra hay kiểm soát tính hợp lệ của đối tượng dữ liệu đầu vào. Kẻ tấn công có thể thao túng luồng dữ liệu này bằng cách chèn các đối tượng độc hại (Gadget Chains) nhằm đạt được mục đích thực thi mã từ xa (RCE - Remote Code Execution).

## 📂 Cấu trúc thư mục
* `client/`: Chứa mã nguồn phía Client chịu trách nhiệm tạo và gửi payload độc hại.
  * `GeneratePayload.java`: Mã nguồn sinh ra chuỗi byte độc hại lưu vào file `payload.bin`.
  * `AttackObject.java`: Định nghĩa đối tượng chứa hành vi độc hại độc lập.
* `server/`: Chứa mã nguồn phía Server mô phỏng dịch vụ bị tổn thương.
  * `MainServer.java`: Khởi chạy Server, lắng nghe kết nối và thực hiện `readObject()` gây lỗi.
  * `User.java`: Đối tượng mô phỏng dữ liệu thông thường được trao đổi.

## 🚀 Hướng dẫn chạy PoC

### 1. Khởi chạy Server
Di chuyển vào thư mục `server/src` và biên dịch/chạy `MainServer`:
```bash
javac MainServer.java User.java AttackObject.java
java MainServer

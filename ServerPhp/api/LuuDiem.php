<?php
include_once '../dbConnect.php';

header('Content-Type: application/json');

if (isset($_POST["taiKhoan"])) {

    $taiKhoan = $_POST["taiKhoan"];
    $matKhau = $_POST["matKhau"];
    $maDeThi = $_POST["maDeThi"];
    $hoTen = $_POST["hoTen"];
    $diem = $_POST["diem"];

    $db = new dbConnect();
    $conn = $db->connect();

    // Câu lệnh Select dùng để xem dữ liệu
    $sql = "SELECT * FROM taikhoan Where TenTaiKhoan = '$taiKhoan' AND MatKhau = '$matKhau'";
    $result = $conn->query($sql);

    ob_clean();
    //Đọc dữ liệu từ MySQL
    if ($result->fetch_assoc()) {
        $sqlInsert = "INSERT INTO ketqua(HoTen, Diem, MaDeThi) VALUES('$hoTen', $diem, $maDeThi)";
        $result = $conn->query($sqlInsert);

        //Trả lại trạng thái sau khi thêm dữ liệu
        echo '{ "status":true }';
    } else {
        //Trả lại trạng thái sau khi thêm dữ liệu
        echo '{ "status":false }';
    }
} else {
    //Trả lại trạng thái sau khi thêm dữ liệu
    ob_clean();
    echo '{ "status":false }';
}

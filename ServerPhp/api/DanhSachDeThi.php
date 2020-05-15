<?php
include_once '../dbConnect.php';

function dispInfo()
{
    $db = new dbConnect();
    $conn = $db->connect();

    // Mảng JSON
    $response = array();
    $response["DanhSachDeThi"] = array();

    // Câu lệnh Select dùng để xem dữ liệu
    $sql = "SELECT * FROM dethi WHERE 20 >= (SELECT COUNT(MaDeThi) FROM bodethi WHERE dethi.MaDeThi = bodethi.MaDeThi)";

    $result = $conn->query($sql);
    //Đọc dữ liệu từ MySQL
    while ($row = $result->fetch_assoc()) {
        // Mảng JSON
        array_push($response["DanhSachDeThi"], $row);
    }
    // Thiết lập header là JSON
    header('Content-Type: application/json');
    // Hiển thị kết quả
    ob_clean();
    echo json_encode($response,JSON_UNESCAPED_UNICODE);
}
dispInfo();

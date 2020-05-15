<?php
include_once '../dbConnect.php';

function dispInfo($maDeThi)
{
    $db = new dbConnect();
    $conn = $db->connect();

    // Mảng JSON
    $response = array();
    $response["BaiThi"] = array();

    // Câu lệnh Select dùng để xem dữ liệu
    $sql = "SELECT * FROM bodethi inner join cauhoi on bodethi.MaCauHoi = cauhoi.MaCauHoi WHERE bodethi.MaDeThi = $maDeThi";
    $result = $conn->query($sql);
    //Đọc dữ liệu từ MySQL
    while ($row = $result->fetch_assoc()) {
        $t = array();
        $row["DapAn"] = getDapAn($conn, $row["MaCauHoi"]);

        $t = $row;
        // Mảng JSON
        array_push($response["BaiThi"], $t);
    }
    // Thiết lập header là JSON
    header('Content-Type: application/json');
    // Hiển thị kết quả
    ob_clean();
    echo json_encode($response,JSON_UNESCAPED_UNICODE);
}

function getDapAn($conn, $maBaiThi){
    // Câu lệnh Select dùng để xem dữ liệu
    $sql = "SELECT * FROM dapan Where MaCauHoi = '$maBaiThi'";
    $result = $conn->query($sql);

    $rl = array();
    //Đọc dữ liệu từ MySQL
    while ($row = $result->fetch_assoc()) {
        array_push($rl, $row);
    }

    return $rl;
}

if(isset($_GET["maDeThi"])){
    dispInfo($_GET["maDeThi"]);
}else{
    $response = array();
    $response["BaiThi"] = array();
    ob_clean();
    echo json_encode($response);
}



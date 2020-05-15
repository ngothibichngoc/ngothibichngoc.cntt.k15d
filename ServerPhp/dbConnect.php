<?php
class dbConnect
{
    private $conn;
    // Phương thức khởi tạo
    function __construct()
    {
        // Kết nối đến database
        // $this->connect();
    }
    function __destruct()
    {
        // Đóng kết nối
        $this->close();
    }
    /**
     * Thiết lập kết nối đến CSDL
     *
     */
    function connect()
    {
        include_once dirname(__FILE__) . '/config.php';
        /////////////////////////////////////////////////////////////////////
        // Kết nối đến MySQL
        $this->conn = new mysqli(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);
        /////////////////////////////////////////////////////////////////////
        // Kết nối đến PostgreSQL Heroku
        // $db = parse_url(getenv("DATABASE_URL"));
        // $this->conn = new PDO("pgsql:" . sprintf(
        //     "host=%s;port=%s;user=%s;password=%s;dbname=%s",
        //     $db["host"],
        //     $db["port"],
        //     $db["user"],
        //     $db["pass"],
        //     ltrim($db["path"], "/")
        // ));
        ///////////////////////////////////////////////////////////////////////
       
        if($this->conn->connect_error){
            die("Kết nối thất bại ". $this->conn->connect_error);
        }
	//mysqli_set_charset($this->conn,"utf-8");
        // Trả về đối tượng connection
        return $this->conn;
    }
    /**
     * Đóng kết nối
     */
    function close()
    {
        // Đóng kết nối CSDL
       $this->conn->close();
    }
}


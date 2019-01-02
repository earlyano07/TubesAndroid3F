<?php if (!defined('BASEPATH')) exit('No direct script access allowed');

class Login extends CI_Model
{
    function __construct()
    {
        parent::__construct();
    }

    function LoginApi($username, $password)
    {
        $result = $this->db->query("SELECT username, password, alamat, telp, email FROM user WHERE username = '$username' AND password = '$password'");
        return $result->result();
    }
}
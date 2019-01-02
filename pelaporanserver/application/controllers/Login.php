<?php if (!defined('BASEPATH')) exit('No direct script access allowed');

class Login extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model('login');
    }

    public function index()
    {
        
    }

    public function LoginApi()
    {
        $username = $this->input->post('username');
        $password = $this->input->post('password');
        $result = $this->dbandroid->LoginApi($username, $password);
        echo json_encode($result);
    }
}
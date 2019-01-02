<?php 
require APPPATH . '/libraries/REST_Controller.php';
/**
* 
*/
class User extends REST_Controller
{
	function __construct($config = 'rest')
	{
		parent::__construct($config);
	}

	function index_get(){
		$username = $this->get('username');
		$password = $this->get('password');
		if ($username == '' && $password='') {
            $get_user = $this->db->get('user')->result();
            $this->response(array("status"=>"success","result" => $get_user));
        } else {
            $this->db->where('username', $username);
            $this->db->where('password', $password);
            $get_user = $this->db->get('user')->result();
            if($this->db->affected_rows() > 0){	
				$this->response(array("status"=>"failed", 502));
            }
            else{   
				$this->response(array("status"=>"success","result" => $get_user));
            }
        }
  		// $this->response($kontak, 200);
		// $get_user = $this->db->query("SELECT u.id_user, u.username, u.password, u.alamat, u.telp, u.email FROM user as u")->result();
	}

	function index_post()
	{
		$data = array(
			'username'		=> $this->post('username'),
			'password'		=> $this->post('password'),
			'alamat'	=> $this->post('alamat'),
			'telp'		=> $this->post('telp'),
			'email'		=> $this->post('email'));
		$insert = $this->db->insert('user', $data);
		if($insert){
			$this->response($data, 200);
		}else{
			$this->response(array("status"=>"failed", 502));
		}
		// $this->insertKecelakaan($data);
	}

	// function insertKecelakaan($data)
	// {
	// 	//upload gambar
	// 	$uploaddir = str_replace("application", "", APPPATH).'uploload/';
	// 		if(!file_exists($uploaddir) && !is_dir($uploaddir)){
	// 			echo mkdir($uploaddir, 0750, true);
	// 		}
	// 		if(!empty($_FILES)){
	// 			$path = $_FILES['gambar']['name'];
	// 			$ext = pathinfo($path, PATHINFO_EXTENSION);
	// 			$kecelakaan_img = $data['deskripsi'].'.'."png";
	// 			$uploadfile = $uploaddir . $kecelakaan_img;

	// 			$data['gambar'] = "upload/".$kecelakaan_img;
	// 		}else{
	// 			$data['gambar'] = "";
	// 		}

	// 	$insert = $this->db->insert('kecelakaan', $data);
	// 	if(!empty($_FILES)){
	// 		if($_FILES["gambar"]["name"]){
	// 			if(move_uploaded_file($_FILES["gambar"]"tmp_name", $uploadfile)){
	// 				$insert_img = "success";
	// 			}else{
	// 				$insert_img = "failed";
	// 			}
	// 		}else{
	// 			$insert_img = "Gambar tidak dimasukkan";
	// 		}

	// 		$data['gambar'] = base_url()."upload/".'resut'	=> array($data), "message" => $insert;
	// 	}else{
	// 		$data['gambar'] = "";
	// 	}

	// 	if($insert){
	// 		$this->response(array('status'=>'success', 'result' => array($data), 'message' => $insert));
	// 	}
	// }
	// else{
	// 	$this->response(array('status'=>'failed', 'message' => "gagal"));
	// }
}
?>
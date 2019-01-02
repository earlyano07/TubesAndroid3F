<?php 
require APPPATH . '/libraries/REST_Controller.php';
/**
* 
*/
class Kecelakaan extends REST_Controller
{
	function __construct($config = 'rest')
	{
		parent::__construct($config);
	}

	function index_get(){

		$username = $this->get('username');
        if ($username == '') {
        	$this->db->select("kecelakaan.id_kecelakaan, kecelakaan.deskripsi, kecelakaan.waktu, kecelakaan.lokasi, kecelakaan.keterangan, kecelakaan.gambar, user.id_user, user.username, user.password, user.alamat, user.telp, user.email");
            $this->db->join("user", "kecelakaan.username = user.username");
            $this->db->order_by('id_kecelakaan', 'desc');
            $get_kecelakaan = $this->db->get('kecelakaan')->result();
        } else {
        	$this->db->select("kecelakaan.id_kecelakaan, kecelakaan.deskripsi, kecelakaan.waktu, kecelakaan.lokasi, kecelakaan.keterangan, kecelakaan.gambar, user.id_user, user.username, user.password, user.alamat, user.telp, user.email");
            $this->db->join("user", "kecelakaan.username = user.username");
            $this->db->order_by('id_kecelakaan', 'desc');
            $this->db->where('kecelakaan.username', $username);
            $get_kecelakaan = $this->db->get('kecelakaan')->result();
        }
        // $this->response($kontak, 200);

		// $get_kecelakaan = $this->db->query("SELECT k.id_kecelakaan, k.deskripsi, k.waktu, k.lokasi, k.gambar, k.keterangan FROM kecelakaan as k")->result();
		$this->response(array("status"=>"success","result" => $get_kecelakaan));
	}

	function index_post()
	{
		$data = array(
			'deskripsi'		=> $this->post('deskripsi'),
			'lokasi'		=> $this->post('lokasi'),
			'keterangan'	=> $this->post('keterangan'),
			'gambar'		=> $this->post('gambar'),
			'username'		=> $this->post('username'));
		$insert = $this->db->insert('kecelakaan', $data);
		if($insert){
			$this->response($data, 200);
		}else{
			$this->response(array("status"=>"failed", 502));
		}
		// $this->insertKecelakaan($data);
	}

	function insertKecelakaan_post()
	{

		$name = date('YmdHmis').'.png';
		$config['upload_path']   = './upload/'; 
        $config['allowed_types'] = 'gif|jpg|png'; 
        $config['file_name']        = $name;

         $this->load->library('upload', $config);

        if ( ! $this->upload->do_upload('files'))
        {

            $this->response(array("status"=>"failed",'error' => $this->upload->display_errors(), 502));
        }
        else
        {
        	$data = array (
        			'waktu'=>$this->post('waktu'),
        			'lokasi'=>$this->post('lokasi'),
        			'gambar'=>$name,
        			'username'=>$this->post('username'),
        			'keterangan'=>$this->post('keterangan'),
        			'deskripsi'=>$this->post('deskripsi')
        		);
        	$insert = $this->db->insert('kecelakaan', $data);
            $this->response(array("status"=>"sukses", 200));

        }
	}

	function index_put() {
	$id = $this->put('id_kecelakaan');
	$data = array(
	'id_kecelakaan' => $this->put('id_kecelakaan'),
	'deskripsi' => $this->put('deskripsi'),
	'keterangan' => $this->put('keterangan'),
	'lokasi' => $this->put('lokasi'));
	// 'gambar' => $this->put('gambar'),
	// 'username' => $this->put('username'));
	$this->db->where('id_kecelakaan', $id);
	$update = $this->db->update('kecelakaan', $data);
		if ($update) {
		$this->response($data, 200);
		} else {
		$this->response(array('status' => 'fail', 502));
		}
	}

	function index_delete() {
	$id = $this->delete('id_kecelakaan');
	$this->db->where('id_kecelakaan', $id);
	$delete = $this->db->delete('kecelakaan');
		if ($delete) {
		$this->response(array('status' => 'success'), 201);
		} else {
		$this->response(array('status' => 'fail', 502));
		}
	}


}
?>
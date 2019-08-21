package com.example.faiq.guest_book.model;


import com.google.gson.annotations.SerializedName;


public class Tamu{

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("email")
	private String email;

	@SerializedName("alamat")
	private String alamat;

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"Tamu{" + 
			"keterangan = '" + keterangan + '\'' + 
			",nama = '" + nama + '\'' + 
			",id = '" + id + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",email = '" + email + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}
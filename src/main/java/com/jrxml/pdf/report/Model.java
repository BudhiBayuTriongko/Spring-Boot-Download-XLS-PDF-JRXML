package com.jrxml.pdf.report;

public class Model {
	private Integer no;
	private String namaPelanggan;
	private Integer noKontrak;
	private String orderId;
	private String kodeProduk;
	private String namaProduk;
	private String namaPartner;
	private String namaBarang;
	private String pembayaran;
	private String tanggalBuat;
	private String status;
	private String imei;
	private String noFaktur;
	private String namaPos;
	private Integer hargaBarang;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getNamaPelanggan() {
		return namaPelanggan;
	}
	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	public Integer getNoKontrak() {
		return noKontrak;
	}
	public void setNoKontrak(Integer noKontrak) {
		this.noKontrak = noKontrak;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getKodeProduk() {
		return kodeProduk;
	}
	public void setKodeProduk(String kodeProduk) {
		this.kodeProduk = kodeProduk;
	}
	public String getNamaProduk() {
		return namaProduk;
	}
	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}
	public String getNamaPartner() {
		return namaPartner;
	}
	public void setNamaPartner(String namaPartner) {
		this.namaPartner = namaPartner;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public String getPembayaran() {
		return pembayaran;
	}
	public void setPembayaran(String pembayaran) {
		this.pembayaran = pembayaran;
	}
	public String getTanggalBuat() {
		return tanggalBuat;
	}
	public void setTanggalBuat(String tanggalBuat) {
		this.tanggalBuat = tanggalBuat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getNoFaktur() {
		return noFaktur;
	}
	public void setNoFaktur(String noFaktur) {
		this.noFaktur = noFaktur;
	}
	public String getNamaPos() {
		return namaPos;
	}
	public void setNamaPos(String namaPos) {
		this.namaPos = namaPos;
	}
	public Integer getHargaBarang() {
		return hargaBarang;
	}
	public void setHargaBarang(Integer hargaBarang) {
		this.hargaBarang = hargaBarang;
	}
	@Override
	public String toString() {
		return "Model [no=" + no + ", namaPelanggan=" + namaPelanggan + ", noKontrak=" + noKontrak + ", orderId="
				+ orderId + ", kodeProduk=" + kodeProduk + ", namaProduk=" + namaProduk + ", namaPartner=" + namaPartner
				+ ", namaBarang=" + namaBarang + ", pembayaran=" + pembayaran + ", tanggalBuat=" + tanggalBuat
				+ ", status=" + status + ", imei=" + imei + ", noFaktur=" + noFaktur + ", namaPos=" + namaPos
				+ ", hargaBarang=" + hargaBarang + "]";
	}
	
}

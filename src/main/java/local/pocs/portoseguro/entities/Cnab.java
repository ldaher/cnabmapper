package local.pocs.portoseguro.entities;

public class Cnab {

	private Header header;

	private Trailer trailer;

	private Lote lote;

	private ServicoProduto servicoProduto;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public ServicoProduto getServicoProduto() {
		return servicoProduto;
	}

	public void setServicoProduto(ServicoProduto servicoProduto) {
		this.servicoProduto = servicoProduto;
	}

}

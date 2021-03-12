package numero1;

public class ItemPedido {
	public String produto;
	public int quant;
	public float valorTotal;

	public ItemPedido(String produto, int quant, float valorTotal) {
	this.produto = produto;
	this.quant = quant;
	this.valorTotal = valorTotal;
	}
	
	public String retornaItemPedido() {
		return "Produto: " + produto + "\nQuantidade: " + quant + "\nValor total: R$" + valorTotal;
	}
}

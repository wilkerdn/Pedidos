package numero1;

public class Pedido {
	public String descricao;
	public String data;
	public ItemPedido[] itens;
	
	public Pedido(String descricao, String data) {
		this.descricao = descricao;
		this.data = data;
		itens = new ItemPedido[10];
	}
	
	public void insereItem(ItemPedido item) {
		for(int i=0;i<itens.length;i++) {
			if(itens[i]==null) {
				itens[i] = item;
				break;
			}
		}
	}
}	
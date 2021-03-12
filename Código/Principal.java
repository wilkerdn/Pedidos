package numero1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		
		int op, op1, i, j;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:\n"
					+ "1 - Criar pedido\n2 - Imprimir pedido\n3 - Sair"));
		
			switch(op) {
				case 1:
					String desc = JOptionPane.showInputDialog("Digite a descrição:");
					String data = JOptionPane.showInputDialog("Digite a data:");
					Pedido p = new Pedido(desc, data);
					do {
						if(p.itens[p.itens.length-1] == null) {
							String prod = JOptionPane.showInputDialog("Digite o nome do produto:");
							int qtde = Integer.parseInt(JOptionPane.showInputDialog("Digite a quatidade do produto:"));
							float valor = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor total do produto:"));
							ItemPedido ip = new ItemPedido(prod, qtde, valor);
							p.insereItem(ip);
						}else {
							JOptionPane.showMessageDialog(null,"Vetor cheio!");
						}
						op1 = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais 1 item?\n"
								+ "1 - Sim\n2 - Não"));
					}while(op1==1);
					pedidos.add(p);
					break;
				case 2:
					for(i=0;i<pedidos.size();i++) {
						if(pedidos.isEmpty()) {
							JOptionPane.showMessageDialog(null,"Lista de pedidos vazia!");
							break;
						}else {
							String imp = ("PEDIDO\nDescrição: "
									+ pedidos.get(i).descricao
									+ "\nData: " + pedidos.get(i).data);
							for(j=0; j<pedidos.get(i).itens.length;j++) {
								if(pedidos.get(i).itens[j]!=null) {
								imp += "\n\n"+pedidos.get(i).itens[j].retornaItemPedido();
								}else {
									break;
								}
							}
							JOptionPane.showMessageDialog(null, imp, "PEDIDO", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					/*for(Pedido paux: pedidos){
					 *	String imp = ("Pedido\nDescrição: " + paux.descricao + "\nData: " + paux.data);
					 *	for(i=0;i<paux.itens.length;i++){
					 * 		if(paux.itens[i]!=null){
					 * 			imp += "\n\n"+paux.itens[i].retornaItemPedido();
					 * 		}else{
					 * 			break;
					 * 		}
					 *	}
					 *	JOptionPane.showMessageDialog(null, imp, "PEDIDO", JOptionPane.INFORMATION_MESSAGE);
					 *}
					*/
					break;
				case 3:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcão inválida!");
					break;
			}
		}while(op!=3);
	}
}
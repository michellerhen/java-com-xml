package br.com.alura.model;

import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccesType.FIELD)
public class Vendas {
	
	private String formaDePagamento;
	
	@XmlElementWrapper(name="produtos")
	@XmlElement(name="produto")
    private List<Produto> produtos;

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    } 
}

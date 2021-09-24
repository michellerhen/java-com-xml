package br.com.alura.Teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.model.Produto;

public class PesquisaComXPath {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, Exception  {
    	DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
    	fabrica.setValidating(true);
    	fabrica.setNamespaceAware(true);
    	fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        DocumentBuilder builder = fabrica.newDocumentBuilder();
        Document document = builder.parse("src/vendas.xml");
        
        Element venda = document.getDocumentElement();
        String moeda = venda.getAttribute("moeda");
        System.out.println(moeda);
        
        //buscar tudo
        //String exp = "/venda/produtos/produto";
        //ou buscar uma express�o
        String exp = "/venda/produtos/produto[contains(nome, 'Livro')]";
        XPath path = XPathFactory.newInstance().newXPath();
        XPathExpression expression = path.compile(exp);

        NodeList produtos = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

        for(int i = 0;i < produtos.getLength();i++) {
        	Element produto = (Element) produtos.item(i);
            String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
            double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
            Produto prod = new Produto(nome, preco);

            System.out.println(prod);

        }
    }

}
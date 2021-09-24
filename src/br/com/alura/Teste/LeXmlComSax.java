package br.com.alura.Teste;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.Handlers.ProdutosHandler;


// Esta forma é quando queremos alguns dados do arquivo xml e não precisa mantê-los na memoria.

public class LeXmlComSax {
	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler(); //ler o xml
		leitor.setContentHandler(logica);
		InputStream ips = new FileInputStream("src/vendas.xml");
		InputSource is = new InputSource(ips);
		leitor.parse(is);
		
		System.out.println(logica.getProdutos());
	}
	
}

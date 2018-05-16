import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonArchive {

	
	//creating a json archive
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {


		FileWriter file = null;
		JSONObject cliente = new JSONObject();
		cliente.put("nome", "Luana");
		cliente.put("saldo", "1000");
		JSONObject t = new JSONObject();

		t.put("debit", 200);
		t.put("credit", 150);


		JSONArray transacoes = new JSONArray();
		transacoes.add(t);

		cliente.put("transacoes", transacoes);

		try {
			file = new FileWriter("createCustomer.json");
			file.write(cliente.toJSONString());
			file.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(cliente.toJSONString());

		
		//json to TXT
		

		File file1 = new File("transacoes.txt");

		try(PrintWriter writer = new PrintWriter(file1)){

			
			writer.print(cliente.toJSONString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//json reader
		
		
		Scanner input;
		try {
			input = new Scanner(file1);
			StringBuilder jsonIn = new StringBuilder();

			while(input.hasNextLine()) {
				jsonIn.append(input.nextLine());
			}

			JSONParser parser = new JSONParser();
			JSONObject clienteOBJ = (JSONObject) parser.parse(jsonIn.toString());

			System.out.printf("Nome do cliente: %s\n", clienteOBJ.get("nome"));
			System.out.printf("Saldo: %s\n", clienteOBJ.get("saldo"));
			JSONArray transacoesIn = (JSONArray) clienteOBJ.get("transacoes");
			
			for(int i=0;i<transacoesIn.size();i++) {
				
				JSONObject transacaoIn = (JSONObject) transacoesIn.get(i); 
				Long debitIn = (Long) transacaoIn.get("debit");
				Long creditIn = (Long) transacaoIn.get("credit");
				
				System.out.printf("Debito: %s Credito: %s", debitIn, creditIn);
			}
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}
}


package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Empresa> empresas = new Banco().getListaEmpresa();

		String valor = "";
		
		if(request.getHeader("Accepet")!=null)
			valor = request.getHeader("Accepet");

		if (valor.contains("xml")) {

			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);

			response.setContentType("application/xml");
			response.getWriter().print(xml);

		} else if (valor.contains("json")) {

			Gson gson = new GsonBuilder().setPrettyPrinting()
					.registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
			String json = gson.toJson(empresas);

			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	}

}

class LocalDateAdapter implements JsonSerializer<LocalDate> {

	@Override
	public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}

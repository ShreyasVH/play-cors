package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import play.mvc.BodyParser;
import java.util.HashMap;
import play.libs.Json;

public class IndexController extends Controller
{
	public static class InputClass
	{
		public String a;
		public String b;
	}

	public Result get(String input)
	{
		return ok(Json.toJson(new HashMap<String, String>(){{put("input", input);}}));
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result post(Http.Request request)
	{
		return ok(Json.toJson(new HashMap<String, InputClass>(){{put("input", Json.fromJson(request.body().asJson(), InputClass.class));}}));
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result put(Http.Request request)
	{
		return ok(Json.toJson(new HashMap<String, InputClass>(){{put("input", Json.fromJson(request.body().asJson(), InputClass.class));}}));
	}

	public Result delete(String input)
	{
		return ok(Json.toJson(new HashMap<String, String>(){{put("input", input);}}));
	}
}
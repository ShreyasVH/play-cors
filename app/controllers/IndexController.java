package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import play.mvc.BodyParser;
import java.util.HashMap;
import java.util.Map;

import play.libs.Json;

public class IndexController extends Controller
{
	public static class InputClass
	{
		public String a;
		public String b;
	}

	public Result get(String input, Http.Request request)
	{
		return ok(Json.toJson(Map.of(
			"input", input,
			"headers", Json.toJson(request.getHeaders().asMap())
		)));
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result post(Http.Request request)
	{
		return ok(Json.toJson(Map.of(
			"input", Json.fromJson(request.body().asJson(), InputClass.class),
			"headers", Json.toJson(request.getHeaders().asMap())
		)));
	}

	@BodyParser.Of(BodyParser.Json.class)
	public Result put(Http.Request request)
	{
		return ok(Json.toJson(Map.of(
				"input", Json.fromJson(request.body().asJson(), InputClass.class),
				"headers", Json.toJson(request.getHeaders().asMap())
		)));
	}

	public Result delete(String input, Http.Request request)
	{
		return ok(Json.toJson(Map.of(
				"input", input,
				"headers", Json.toJson(request.getHeaders().asMap())
		)));
	}
}
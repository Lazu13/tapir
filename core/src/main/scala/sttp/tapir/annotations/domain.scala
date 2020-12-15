package sttp.tapir.annotations

import java.nio.charset.StandardCharsets
import sttp.tapir.CodecFormat
import sttp.tapir.EndpointInput.WWWAuthenticate
import sttp.tapir.RawBodyType
import sttp.tapir.RawBodyType.StringBody

import scala.annotation._

class path extends StaticAnnotation

class query(val name: String = "") extends StaticAnnotation

class params extends StaticAnnotation

class header(val name: String = "") extends StaticAnnotation

class headers extends StaticAnnotation

class cookie(val name: String = "") extends StaticAnnotation

class cookies extends StaticAnnotation

class body[R, CF <: CodecFormat](val bodyType: RawBodyType[R], val cf: CF) extends StaticAnnotation

class jsonbody extends body(StringBody(StandardCharsets.UTF_8), CodecFormat.Json())

class xmlbody extends body(StringBody(StandardCharsets.UTF_8), CodecFormat.Xml())

class apikey(val challenge: WWWAuthenticate = WWWAuthenticate.apiKey()) extends StaticAnnotation

class basic(val challenge: WWWAuthenticate = WWWAuthenticate.basic()) extends StaticAnnotation

class bearer(val challenge: WWWAuthenticate = WWWAuthenticate.bearer()) extends StaticAnnotation

class endpointInput(val path: String = "") extends StaticAnnotation

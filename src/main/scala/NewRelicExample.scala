/* ===================================================
 * Copyright © 2013 2014 the kamon project <http://kamon.io/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp
import util.Properties

object NewRelicExample extends App with SimpleRoutingApp {

  implicit val system = ActorSystem("kamon-system")

  val interface = "0.0.0.0"
  val port = Properties.envOrElse("PORT", "8080").toInt // for Heroku compatibility

  startServer(interface = interface, port = port) {
    path("helloKamon") {
      get {
        complete {
          <h1>Say hello to Kamon</h1>
        }
      }
    } ~
    path("helloNewRelic") {
      get {
        complete {
          <h1>Say hello to NewRelic</h1>
        }
      }
    }
  }
}

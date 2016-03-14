/*
 * Copyright 2012-2014 the original author or authors. Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package sample.jersey;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Named
public class SubEndpoint
{

	private final Service service;

	@Context
	private HttpServletRequest request;

	@Autowired
	public SubEndpoint(final Service service)
	{
		this.service = service;
	}

	@GET
	public String message()
	{
		// request shouldb't be null, but it is when using Jersey 2.22.2
		return "Hello from " + request.getRequestURI() + ": " + service.message();
	}

}

/**
 * Copyright (c) 2012 Mark S. Kolich
 * http://mark.koli.ch
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.kolich.havalo.client.signing;

import com.kolich.havalo.client.signing.algorithms.HavaloSigningAlgorithm;
import org.apache.http.client.methods.HttpRequestBase;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class HavaloAbstractSigner {
	
	/**
	 * Our credentials, the access key and access key secret.
	 */
	protected HavaloCredentials credentials_;
	
	/**
	 * The signer that does the real work to generate a proper outgoing
	 * HTTP Authorization request header.
	 */
	protected HavaloSigningAlgorithm signer_;
	
	public HavaloAbstractSigner(HavaloCredentials credentials,
								HavaloSigningAlgorithm signer) {
		credentials_ = checkNotNull(credentials, "The credentials cannot be null!");
		signer_ = checkNotNull(signer, "The signer cannot be null!");
	}
	
	/**
	 * Called when an Havalo client needs to sign a request before it's sent.
	 * The {@link HttpRequestBase} is modified directly in place, which usually
	 * involves checking the service endpoint and adding an Authorization HTTP
	 * request header.
	 * @param request
	 */
	public abstract void signHttpRequest(final HttpRequestBase request);
	
}

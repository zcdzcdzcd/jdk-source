/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 */
/*
   Copyright 2009-2013 Attila Szegedi

   Licensed under both the Apache License, Version 2.0 (the "Apache License")
   and the BSD License (the "BSD License"), with licensee being free to
   choose either of the two at their discretion.

   You may not use this file except in compliance with either the Apache
   License or the BSD License.

   If you choose to use this file in compliance with the Apache License, the
   following notice applies to you:

       You may obtain a copy of the Apache License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
       implied. See the License for the specific language governing
       permissions and limitations under the License.

   If you choose to use this file in compliance with the BSD License, the
   following notice applies to you:

       Redistribution and use in source and binary forms, with or without
       modification, are permitted provided that the following conditions are
       met:
       * Redistributions of source code must retain the above copyright
         notice, this list of conditions and the following disclaimer.
       * Redistributions in binary form must reproduce the above copyright
         notice, this list of conditions and the following disclaimer in the
         documentation and/or other materials provided with the distribution.
       * Neither the name of the copyright holder nor the names of
         contributors may be used to endorse or promote products derived from
         this software without specific prior written permission.

       THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
       IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
       TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
       PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL COPYRIGHT HOLDER
       BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
       CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
       SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
       BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
       WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
       OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
       ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/**
 * <p>
 * Contains interfaces and classes needed by language runtimes to implement
 * their own language-specific object models and type conversions. The main
 * entry point is the
 * {@link jdk.dynalink.linker.GuardingDynamicLinker} interface. It needs to be
 * implemented in order to provide linking for the runtime's own object model.
 * A language runtime can have more than one guarding dynamic linker
 * implementation. When a runtime is configuring Dynalink for itself, it will
 * normally set these guarding linkers as the prioritized linkers in its
 * {@link jdk.dynalink.DynamicLinkerFactory} (and maybe some of them as fallback
 * linkers, for e.g. handling "method not found" and similar errors in a
 * language-specific manner if no other linker managed to handle the operation.)
 * </p><p>
 * A language runtime that wishes to make at least some of its linkers available
 * to other language runtimes for interoperability will need to use a
 * {@link jdk.dynalink.linker.GuardingDynamicLinkerExporter}.
 * </p><p>
 * Most language runtimes will be able to implement their own linking logic by
 * implementing {@link jdk.dynalink.linker.TypeBasedGuardingDynamicLinker}
 * instead of {@link jdk.dynalink.linker.GuardingDynamicLinker}; it allows for
 * faster type-based linking dispatch.
 * </p><p>
 * Language runtimes that allow type conversions other than those provided by
 * Java will need to have their guarding dynamic linker (or linkers) also
 * implement the {@link jdk.dynalink.linker.GuardingTypeConverterFactory}
 * interface to provide the logic for these conversions.
 * </p>
 * @since 9
 */
package jdk.dynalink.linker;

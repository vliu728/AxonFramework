/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.auditing;

import java.util.UUID;

/**
 * Interface demarcating objects that carry auditing information, such as a correlation ID and a principal name.
 *
 * @author Allard Buijze
 * @since 0.6
 */
public interface Audited {

    /**
     * Returns the correlation identifier of this event, if any. The correlationId can be used to correlate events with
     * the commands that caused them. Multiple events may share the same correlationId if they have been generated by
     * the same command.
     *
     * @return the correlationId of this event, if available.
     */
    UUID getCorrelationId();

    /**
     * Returns the name of the principal that caused this event to be raised. Typically, this is the username of the
     * user that issues the command that caused this event.
     *
     * @return the name of the principal that caused this event
     *
     * @see java.security.Principal
     */
    String getPrincipalName();
}
/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mongodb;

import org.mongodb.rs.ReplicaSet;

/**
 * An exception indicating a failure to find a replica set member that satisfies the requested read preference.
 */
public class MongoReadPreferenceException extends MongoReplicaSetException {

    private static final long serialVersionUID = 1400085417913679244L;

    private final ReadPreference readPreference;

    /**
     * Construct a new instance with the given read preference and replica set state.
     * @param readPreference the read preference
     * @param replicaSetState the replica set
     */
    public MongoReadPreferenceException(final ReadPreference readPreference, final ReplicaSet replicaSetState) {
        super(String.format("Unable to find a replica set member in %s that satisfies a read preference of %s",
                replicaSetState, readPreference), replicaSetState);
        this.readPreference = readPreference;
    }

    /**
     * Gets the requested read preference.
     *
     * @return the read preference
     */
    public ReadPreference getReadPreference() {
        return readPreference;
    }
}

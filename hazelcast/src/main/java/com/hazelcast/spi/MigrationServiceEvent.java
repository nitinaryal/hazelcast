/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
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
 */

package com.hazelcast.spi;

import com.hazelcast.partition.MigrationEndpoint;
import com.hazelcast.partition.MigrationInfo;
import com.hazelcast.partition.MigrationType;

import java.util.EventObject;

/**
 * @mdogan 9/12/12
 */
public class MigrationServiceEvent extends EventObject {

    private final MigrationEndpoint migrationEndpoint;

    private final MigrationType migrationType;

    private final int partitionId;

    private final int replicaIndex;

    private final int copyBackReplicaIndex;

    public MigrationServiceEvent(final MigrationEndpoint migrationEndpoint, final MigrationInfo migrationInfo) {
        this(migrationEndpoint, migrationInfo.getPartitionId(), migrationInfo.getReplicaIndex(),
                migrationInfo.getMigrationType(), migrationInfo.getCopyBackReplicaIndex());
    }

    public MigrationServiceEvent(final MigrationEndpoint migrationEndpoint,
                                 final int partitionId, final int replicaIndex,
                                 final MigrationType migrationType, final int copyBackReplicaIndex) {
        super(partitionId);
        this.migrationEndpoint = migrationEndpoint;
        this.partitionId = partitionId;
        this.replicaIndex = replicaIndex;
        this.migrationType = migrationType;
        this.copyBackReplicaIndex = copyBackReplicaIndex;
    }

    public MigrationEndpoint getMigrationEndpoint() {
        return migrationEndpoint;
    }

    public int getPartitionId() {
        return partitionId;
    }

    public int getReplicaIndex() {
        return replicaIndex;
    }

    public MigrationType getMigrationType() {
        return migrationType;
    }

    public int getCopyBackReplicaIndex() {
        return copyBackReplicaIndex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MigrationServiceEvent");
        sb.append("{migrationEndpoint=").append(migrationEndpoint);
        sb.append(", migrationType=").append(migrationType);
        sb.append(", partitionId=").append(partitionId);
        sb.append(", replicaIndex=").append(replicaIndex);
        sb.append(", copyBackReplicaIndex=").append(copyBackReplicaIndex);
        sb.append('}');
        return sb.toString();
    }
}

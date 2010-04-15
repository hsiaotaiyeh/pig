/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.hadoop.owl.entity;

/**
 * This class represents the Database object for Object Relational Mapping.
 */
public class DatabaseEntity extends OwlResourceEntity {

    /** The id for this database */
    private int    id;

    /** The name for this database */
    private String name;

    /** The owner for this database */
    private String owner;

    /** The description for this database */
    private String description;

    /** The storage location for the data */
    private String location;

    /** The creation time for this Database */
    private long   createdAt;

    /** The last modification time for this Database */
    private long   lastModifiedAt;

    /** The database object version for this entry */
    private int    version;

    /**
     * Instantiates a new database entity.
     */
    public DatabaseEntity() {
    }

    /**
     * Instantiates a new database entity.
     * 
     * @param name
     *            the name
     * @param owner
     *            the owner
     * @param description
     *            the description
     * @param location
     *            the location
     */
    public DatabaseEntity(String name, String owner, String description,
            String location) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.location = location;
    }

    /**
     * Instantiates a new database entity.
     * 
     * @param id
     *            the id
     * @param name
     *            the name
     * @param owner
     *            the owner
     * @param description
     *            the description
     * @param location
     *            the location
     * @param createdAt
     *            the created at
     * @param lastModifiedAt
     *            the last modified at
     * @param version
     *            the version
     */
    public DatabaseEntity(int id, String name, String owner, String description,
            String location, long createdAt, long lastModifiedAt, int version) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.location = location;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
        this.version = version;
    }

    /**
     * Gets the value of id
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the value of name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the value of owner
     * @return the owner
     */
    @Override
    public String getOwner() {
        return owner;
    }

    /**
     * Gets the value of description
     * @return the description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Gets the value of storage location
     * @return the storage
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the value of createdAt
     * @return the createdAt timestamp
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets the value of lastModifiedAt
     * @return the lastModifiedAt timestamp
     */
    public long getLastModifiedAt() {
        return lastModifiedAt;
    }

    /**
     * Gets the value of version
     * @return the version
     */
    @Override
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the value of name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the value of owner
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Sets the value of description
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the value of storage location
     * @param location the location to set
     */
    public void setStorage(String location) {
        this.location = location;
    }

    /**
     * Sets the value of createdAt
     * @param createdAt the createdAt to set
     */
    @Override
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Sets the value of lastModifiedAt
     * @param lastModifiedAt the lastModifiedAt to set
     */
    @Override
    public void setLastModifiedAt(long lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    /**
     * Sets the value of version
     * @param version the version to set
     */
    @Override
    public void setVersion(int version) {
        this.version = version;
    }

}

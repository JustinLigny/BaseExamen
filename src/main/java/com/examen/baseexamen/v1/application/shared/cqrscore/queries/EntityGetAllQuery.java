package com.examen.baseexamen.v1.application.shared.cqrscore.queries;

/**
 * <h1>EntityGetAllQuery Class</h1><br>
 *
 * <p>The {@code EntityGetAllQuery} class is used to represent a query for retrieving
 * multiple entities with pagination support.</p><br>
 *
 * <p>This class is typically used to fetch a list of entities with specific pagination parameters.</p><br>
 *
 * @author Justin Ligny
 * @since 1.0.0
 */
public class EntityGetAllQuery {

    /**
     * <h2>page</h2>
     * <p>The page number for the query. This determines which page of results will be returned
     * when querying the database. The page number is zero-based, meaning the first page is 0.</p><br>
     *
     * @since 1.0.0
     */
    public int page;

    /**
     * <h2>size</h2>
     * <p>The number of items to return per page. This determines how many entities will be fetched in one query.</p><br>
     * <p>For example, if {@code size} is set to 20, each page will contain at most 20 items.</p><br>
     *
     * @since 1.0.0
     */
    public int size;

    /**
     * <h2>sortBy</h2>
     * <p>The field by which the results should be sorted. This value indicates which entity attribute
     * the query should use to order the results.</p><br>
     * <p>For example, if set to {@code "name"}, the query will return results sorted by the "name" field.</p><br>
     *
     * @since 1.0.0
     */
    public String sortBy;

    /**
     * <h2>sortDirection</h2>
     * <p>The direction in which the results should be sorted. This value can be either {@code "asc"}
     * for ascending order or {@code "desc"} for descending order.</p><br>
     * <p>For example, if {@code sortDirection} is {@code "asc"}, the query will return the results in ascending order
     * based on the field specified by {@code sortBy}.</p><br>
     *
     * @since 1.0.0
     */
    public String sortDirection;

}

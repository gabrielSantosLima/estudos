package com.gabriel.celebration.adapters.db;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

// Plain Sql in JOOQ
// https://www.jooq.org/doc/3.1/manual/sql-building/plain-sql/

public abstract class AbstractRepository {

    public Table<?> table(String table){
        return DSL.table(table);
    }

    public Field<Object> field(String field){
        return DSL.field(field);
    }

}

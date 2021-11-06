package com.github.wz2cool.elasticsearch.operator;

import com.github.wz2cool.elasticsearch.lambda.GetPropertyFunction;
import com.github.wz2cool.elasticsearch.model.ColumnInfo;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;

public class FuzzyOperator<R> implements IFilterOperator<R> {

    private final String value;

    public FuzzyOperator(String value) {
        this.value = value;
    }

    @Override
    public <T> QueryBuilder buildQuery(GetPropertyFunction<T, R> getPropertyFunc) {
        final ColumnInfo columnInfo = getColumnInfo(getPropertyFunc);
        return new FuzzyQueryBuilder(columnInfo.getColumnName(), value);
    }
}

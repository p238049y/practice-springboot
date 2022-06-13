package com.example.springmybatis.da.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class CommaStringToListTypeHandler extends BaseTypeHandler<List<String>> {

    private static final String SEPARATOR = ",";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        StringJoiner sj = new StringJoiner(SEPARATOR);
        parameter.forEach(sj::add);
        ps.setString(i, sj.toString());
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return doGetResult(rs.getString(columnName));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return doGetResult(rs.getString(columnIndex));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return doGetResult(cs.getString(columnIndex));
    }

    private List<String> doGetResult(String value) {
        return Arrays.asList(value.split(SEPARATOR));
    }
}

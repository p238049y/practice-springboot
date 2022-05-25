package com.example.springmybatis.da.typehandler;

import org.apache.ibatis.type.*;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@Service
//@MappedTypes(boolean.class)
//@MappedJdbcTypes(JdbcType.CHAR)
public class PlusMinusBooleanTypeHandler extends BaseTypeHandler<Boolean> {
    private static final String PLUS = "+";
    private static final String MINUS = "-";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        String value = "";
        if(parameter) {
            value = PLUS;
        } else {
            value = MINUS;
        }

        ps.setString(i, value);
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return doGetResult(rs.getString(columnName), columnName);
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return doGetResult(rs.getString(columnIndex), "#" + columnIndex);
    }

    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return doGetResult(cs.getString(columnIndex), "#" + columnIndex);
    }

    private Boolean doGetResult(String value, String columnKey) {
        if (PLUS.equals(value)) {
            return true;
        } else if (MINUS.equals(value)) {
            return false;
        } else {
            throw new TypeException("Error attempting to get column '" + columnKey + "' from result set.");
        }
    }
}

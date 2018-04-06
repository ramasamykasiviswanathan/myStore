package com.doordelivr.dto.model;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorModel implements Serializable
{
    private static final long serialVersionUID = 5203472589728548150L;
    private String message;

    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.message);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof ErrorModel)
        {
            ErrorModel value = (ErrorModel) obj;
            result = Objects.equals(value.getMessage(), this.getMessage());
        }

        return result;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

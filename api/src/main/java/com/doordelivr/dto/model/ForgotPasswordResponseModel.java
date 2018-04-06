package com.doordelivr.dto.model;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.bytebuddy.asm.Advice.This;

public class ForgotPasswordResponseModel implements Serializable
{
    private static final long serialVersionUID = 3983174910022116692L;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Error")
    private ErrorModel errorModel;

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

    /**
     * @return the errorModel
     */
    public ErrorModel getErrorModel()
    {
        return errorModel;
    }

    /**
     * @param errorModel
     *            the errorModel to set
     */
    public void setErrorModel(ErrorModel errorModel)
    {
        this.errorModel = errorModel;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.errorModel, this.message);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof ForgotPasswordResponseModel)
        {
            ForgotPasswordResponseModel value = (ForgotPasswordResponseModel) obj;
            result = Objects.equals(value.getErrorModel(), this.getErrorModel())
                    && Objects.equals(value.getMessage(), this.getMessage());
        }

        return result;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

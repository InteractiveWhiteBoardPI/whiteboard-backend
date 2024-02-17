package com.example.whiteboardbackend.entity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("text")
public class MessageText extends Message {


    @Column(name = "messageBody")
    private String messageBody;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", messageBody='" + getMessageBody() + "'" +
                ", sender='" + super.getSender() + "'" +
                ", receiver='" + super.getReceiver() + "'" +
                "}";
    }

}
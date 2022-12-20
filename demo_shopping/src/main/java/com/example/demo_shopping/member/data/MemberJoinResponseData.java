package com.example.demo_shopping.member.data;


import java.util.List;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberJoinResponseData {

  private Long id;
  private String name;
  private String email;
  private String password;
  private List<AddressDto> addresses;
  private String msg;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberJoinResponseData that = (MemberJoinResponseData) o;
    return id.equals(that.id) && name.equals(that.name) && email.equals(that.email) && password.equals(that.password)
        && Objects.equals(addresses, that.addresses) && Objects.equals(msg, that.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password, addresses, msg);
  }
}

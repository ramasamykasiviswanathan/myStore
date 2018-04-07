export interface IUserIdentity {
  MobileNumber?: String;
  EmailAddress?: String;
  Password?: String;
  NewPassword?: String;
  OTP?: String;
  RetailerCode?: String;
  Name?: String;
}

export interface IErrorModel {
  message: String;
}

export interface ILoginResponse {
  AppId: String;
  UserId: String;
  UserName: String;
  MobileNumber: String;
  EmailAddress: String;
  Error: IErrorModel;
}

export interface IFlagMessageResponse {
  Message?: String;
  Error: IErrorModel;
}

export interface IShowShopsResponse {
  Retailers: Array<IShopInformationModel>;
  Error: IErrorModel;
}

export interface IShopInformationModel {
  ID: String;
  Name: String;
  Business: String;
  StoreID: String;
  TAndC: String;
}

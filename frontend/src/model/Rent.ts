import { Apartment } from "./Apartment";
import { User } from "./User";

export type Rent = {
  id: number;
  user: User;
  apartment: Apartment;
  createdAt: Date;
  durationMonths: string;
  isActive: boolean;
}
interface PhoneInterface {
    name: string;
    email: string;
    phone: string;
}
export class Phone implements PhoneInterface {
    name: string;
    email: string;
    phone: string;

    constructor(name: string, email: string, phone: string) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
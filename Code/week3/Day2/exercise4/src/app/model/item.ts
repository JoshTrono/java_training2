interface ItemInterface {
    id: number;
    name: string;
}

export class Item implements ItemInterface {
    id: number;
    name: string;

    constructor(id: number, name: string) {
        this.id = id;
        this.name = name;
    }
}
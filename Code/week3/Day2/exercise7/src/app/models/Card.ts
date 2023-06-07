interface CardInterface {
    title: string;
    content: string;
}
export class Card implements CardInterface {
    title: string;
    content: string;
    constructor(title: string, content: string) {
        this.title = title;
        this.content = content;
    }
}
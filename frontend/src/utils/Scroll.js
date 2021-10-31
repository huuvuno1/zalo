export function scrollMessageHistory() {
    console.log("scoll")
    let dom = document.querySelector("#my__wrap--history")
    dom.scrollTo(0, dom.scrollHeight)
}
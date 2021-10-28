<template>
  <div class="fixed bottom-0 bg-white w-full my__frame--chat">
            <!-- option send -->
    <div class="flex items-center justify-start p-2 border border-gray-200">
        <label for="f__file" class='bx bxs-file text-2xl mx-2 text-purple-500 cursor-pointer'></label>
        <label for="fImage" class='bx bx-image-alt text-2xl mx-2 text-green-500 cursor-pointer' ></label>
        <i class='bx bxs-wink-smile ml-1 text-2xl text-yellow-500 cursor-pointer border border-gray-300 rounded-full leading-6' ></i>

        <input type="file" id="fImage" hidden multiple accept="image/png, image/gif, image/jpeg">
        <input type="file" id="f__file" hidden multiple>
    </div>
    <!-- input -->
    <div class="flex items-center justify-between p-3">
        <div contenteditable="true" class=" outline-none  overflow-y-scroll" id="txtMessage" @keydown="onTyping"></div>
        
        <!-- <div class="flex justify-between"> -->
        <i class='bx bxs-send text-blue-700 text-2xl cursor-pointer' ></i>
        <!-- </div> -->
        
    </div>
  </div>
</template>

<script>
//import { scrollMessageHistory } from '../utils/Scroll'

export default {
  name: 'TypingBox',
  data() {
    return {
      textChat: "",
      file: File
    }
  },
  methods: {
    onTyping(e) {
      let text = e.target.innerText.trim()
      if (!e.shiftKey && e.key == 'Enter') {
          e.preventDefault();
          if (text != '') {
            this.$emit('send', text)
            e.target.innerHTML = ''
          }
          
      }
      // if (!e.shiftKey && e.key === 'Enter' && this.textChat) {
      //   e.preventDefault()
      //   console.log("vl", this.textChat)
      //   if (this.textChat.trim().replace('\n', '') !== '') {
      //     e.target.innerText = ''
      //     // send chat
      //     console.log("send", this.textChat)
          
      //   }
        
      // }
      // else {
      //     scrollMessageHistory()
      //     this.textChat = e.target.innerText + e.key;
      // }
      
    }
  }
}
</script>

<style>
#txtMessage:empty::before {
  content: 'Nhập tin nhắn...';
  color: black;
}

</style>
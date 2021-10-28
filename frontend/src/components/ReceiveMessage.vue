<template>
  <!-- receive -->
        <div class="my__min--w rounded-full w-11 h-11 bg-white border border-gray-200 mx-1 md:mx-2 my-1">
            <img :src="chat.avatar" alt="" class="rounded-full w-full h-full">
        </div>
        <!-- list chat text -->
        <div class="my__list--chat">
            <div class="bg-white py-1 px-2 rounded my-1" v-for="message in chat.messages" :key="message.timeStamp">
                {{ message.content }}
            </div>
        </div>
</template>

<script>
export default {
    name: 'ReceiveMessage',
    props: ['chat']
}
</script>

<style>

</style>
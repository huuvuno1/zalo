<template>
    <div class=" flex-1 relative h-screen bg-gradient-to-b from-gray-300 to-gray-500 md:block">
        <!-- top -->
        <div class="h-14 md:h-16 border-b border-gray-200 flex items-center justify-between bg-white">
            <!-- left include back and name -->
            <div class="flex items-center">
                <!-- back -->
                <div class="w-6 ml-2 cursor-pointer md:hidden" @click="changeBack">
                    <i class='bx bx-arrow-back font-bold text-2xl'></i>
                </div>

                <!-- rom name -->
                <div class="ml-2 cursor-pointer md:ml-4">
                    <h2 class="font-bold text-sm md:text-lg">Nguyễn Công Minh</h2>
                    <div class="flex items-center">
                        <span class="rounded-full w-2 h-2 bg-green-600"></span>
                        <span class="ml-1 text-xs">Đang hoạt động</span>
                    </div>
                </div>
            </div>
            

            <!-- option -->
            <div class="flex w-28 md:w-36 justify-evenly">
                <!-- call -->
                <div class="text-center">
                    <i class='bx bxs-phone-call text-xl md:text-2xl text-blue-600 cursor-pointer' ></i>
                </div>

                <div class="text-center">
                    <i class='bx bxs-video text-xl md:text-2xl text-blue-600 cursor-pointer' ></i>
                </div>

                <div class="text-center">
                    <i class='bx bx-sidebar text-xl md:text-2xl text-blue-600 cursor-pointer'></i>
                </div>
            </div>
        </div>

        <!-- bottom -->
        <!-- message history -->
        <!-- <div class="bg-gradient-to-b from-gray-300 to-gray-500 h-screen overflow-y-scroll overflow-x-hidden " id="list__message">

            <div class="flex" :class="[chat.sender == 'me' ? 'flex-row-reverse' : '']" v-for="chat in chatHistory" :key="chat.sender">
                <send-message v-if="chat.sender == 'me'" :chat='chat' />
                <receive-message v-else :chat='chat' />
            </div>
        </div> -->
        <div class="overflow-y-scroll overflow-x-hidden pb-2" id="my__wrap--history">
            <div class="flex flex-col-reverse justify-end" id="list__message">
                <div class="flex" :class="[chat.sender == 'me' ? 'flex-row-reverse' : '']" v-for="chat in chatHistory" :key="chat.sender">
                    <send-message v-if="chat.sender == 'me'" :chat='chat'/>
                    <receive-message v-else :chat='chat' />
                </div>
            </div>
        </div>
        
        <!-- input send -->
        <typing-box @send="addE($event)"/>
    </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import ReceiveMessage from './ReceiveMessage.vue'
import SendMessage from './SendMessage.vue'
import TypingBox from './TypingBox.vue'


export default {
    name: 'ChatContainer',
    components: {
        ReceiveMessage,
        SendMessage,
        TypingBox
    },
    data() {
        return {
            //chatHistory: []
        }
    },
    computed: mapState(['chatHistory']),
    methods: {
        addE(data) {
            console.log("send mess", data)
            let newD = {
                    avatar: 'https://i.pinimg.com/736x/fa/02/02/fa0202572e8aa734cedb154c413a4846.jpg',
                    sender: 'me',
                    messages: [
                        {
                            content: data, 
                            timestamp: '4h00'
                        }
                    ]
                }
            this.chatHistory.unshift(newD)
        },
        ...mapMutations(['changeBack'])
    },
    mounted() {
        //this.chatHistory = this.$store.state.chatHistory
    }
}
</script>

<style>
#my__wrap--history {
    height: calc(100vh - 210px);
}

#list__message {
    min-height: calc(100vh - 56px);
}

@media (min-width: 768px) {
    #my__wrap--history {
        height: calc(100vh - 170px);
    }
    #list__message {
        min-height: calc(100vh - 56px);;
    }
}
</style>
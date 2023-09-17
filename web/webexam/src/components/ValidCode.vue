<template>
    <div class="ValidCode disabled-select"
         :style="`width:${width}; height:${height}`"
         @click="refreshCode">
    <span v-for="(item, index) in codeList"
          :key="index"
          :style="getStyle(item)">
      {{item.code}}
    </span>
    </div>
</template>
<script>
    export default {
        name: "ValidCode",
        model: {
            prop: 'value',
            event: 'input'
        },
        props: {
            width: {
                type: String,
                default: '100px'
            },
            height: {
                type: String,
                default: '34px'
            },
            length: {
                type: Number,
                default: 4
            }
        },
        data () {
            return {
                codeList: []
            }
        },
        mounted () {
            this.createdCode()
        },
        methods: {
            refreshCode () {
                this.createdCode()
            },
            createdCode () {
                const len = this.length
                const codeList = []
                const chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz0123456789'
                const charsLen = chars.length
                // 生成
                for (let i = 0; i < len; i++) {
                    const rgb = [Math.round(Math.random() * 220), Math.round(Math.random() * 240), Math.round(Math.random() * 200)]
                    codeList.push({
                        code: chars.charAt(Math.floor(Math.random() * charsLen)),
                        color: `rgb(${rgb})`,
                        fontSize: `1${[Math.floor(Math.random() * 10)]}px`,
                        padding: `${[Math.floor(Math.random() * 10)]}px`,
                        transform: `rotate(${Math.floor(Math.random() * 90) - Math.floor(Math.random() * 90)}deg)`
                    })
                }
                // 指向
                this.codeList = codeList
                // 将当前数据派发出去
                this.$emit('input', codeList.map(item => item.code).join(''))
            },
            getStyle (data) {
                return `color: ${data.color}; font-size: ${data.fontSize}; padding: ${data.padding}; transform: ${data.transform}`
            }
        }
    }
</script>
<style scoped >
    .ValidCode{
        display: flex;
        justify-content: center;
        align-items: center;
        cursor: pointer;
    span{
        display: inline-block;
    }
    }
</style>
————————————————
版权声明：本文为CSDN博主「Blet-」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_65950231/article/details/128066251
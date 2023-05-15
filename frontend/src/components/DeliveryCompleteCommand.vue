<template>

    <v-card outlined>
        <v-card-title>
            DeliveryComplete
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="OrderId" v-model="value.orderId" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
            <String label="Courier" v-model="value.courier" :editMode="editMode"/>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
            <Number label="ProductId" v-model="value.productId" :editMode="editMode"/>
            <String label="CourierName" v-model="value.courierName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="deliveryComplete"
            >
                DeliveryComplete
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DeliveryCompleteCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.userId = '';
            this.value.orderId = 0;
            this.value.status = '';
            this.value.courier = '';
            this.value.qty = 0;
            this.value.productId = 0;
            this.value.courierName = '';
        },
        watch: {
        },
        methods: {
            deliveryComplete() {
                this.$emit('deliveryComplete', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>


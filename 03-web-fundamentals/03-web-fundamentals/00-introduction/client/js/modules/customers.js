const customers = $.get('/api/customers');

export default function controller() {
    
}

function _list(filter, event) {
    return customers.then(data => {
        $('#customer-list').html(null);

        const filteredData = data.filter(filter);

        filteredData.forEach((customer, index) => {
            $('<a />', {
                id: `customer-${index}`,
                'data-id': customer.Id,
                'data-index': index,
                href: `#${customer.Id}`,
                text: customer.ContactName
            }).appendTo('#customer-list');

            $('<br />').appendTo('#customer-list');
        });

        $('#customer-list > a').click(showCustomerDetails);
    });
}

function _hideCustomerDetails($customerDetails) {
    return event => {
        $customerDetails.slideUp(400, function() {
            $customerDetails.empty();
        });
    };
}

export function list(event) {
    return _list(() => true, event);
}

export function listLondoners(event) {
    return _list(customer => customer.City == 'London', event);
}

export function showCustomerDetails(event) {
    event.preventDefault();

    const index = $(this).data('index');

    const $customerDetails = $('#customer-details');
    $customerDetails.empty();

    customers.then(data => {
        const customer = data[index];
        console.log(customer);

        $(`
            <br />
            <span>${customer.ContactName}'s details</span>
            <button id="clear-customer-details">Close</button><br />
            <hr />
            <h2>${customer.ContactName}</h2>
            <h3>${customer.ContactTitle}, ${customer.CompanyName}</h3>
            <p>
                <strong>Tel.:</strong> ${customer.Phone}<br />
                <strong>Fax:</strong> ${customer.Fax}
            </p>
            <p>
                <strong>Address:</strong><br />
                ${customer.Address}<br />
                ${customer.City} ${customer.PostalCode}<br />
                ${customer.Country}
            </p>
            <hr />
        `).appendTo($customerDetails);

        $('#clear-customer-details').click(_hideCustomerDetails($customerDetails));
    });
}
